import React, { useState, useEffect } from 'react';
import { getOffers, applyForLoan } from '../services/customerService';
import { useNavigate } from 'react-router-dom';
import '../css/GetOffers.css';

const GetOffers = () => {
    const [phoneNumber, setPhoneNumber] = useState('');
    const [offers, setOffers] = useState([]);
    const [selectedOffer, setSelectedOffer] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const storedPhoneNumber = localStorage.getItem('phoneNumber');
        if (storedPhoneNumber) {
            setPhoneNumber(storedPhoneNumber);
        } else {
            navigate('/');
        }
    }, [navigate]);

    const handleGetOffers = async (e) => {
        e.preventDefault();
        try {
            const response = await getOffers(phoneNumber);
            console.log(response.data);
            setOffers(response.data);
        } catch (error) {
            console.error('Fetching offers failed', error);
        }
    };

    const handleApplyForLoan = async (offerId) => {
        try {
            const response = await applyForLoan(phoneNumber, offerId);
            console.log('Loan application successful:', response.data);
            alert('Loan application successful!');
        } catch (error) {
            console.error('Applying for loan failed', error);
        }
    };

    return (
        <div className="offers-container">
            <h2>Offers</h2>
            <button onClick={handleGetOffers}>Get Offers</button>
            {offers.length > 0 && (
                <div className="offers-list">
                    <ul>
                        {offers.map((offer) => (
                            <li key={offer.id}>
                                <button onClick={() => setSelectedOffer(offer)}>
                                    {offer.description}
                                </button>
                            </li>
                        ))}
                    </ul>
                </div>
            )}
            {selectedOffer && (
                <div className="selected-offer">
                    <h3>Selected Offer</h3>
                    <p>Description: {selectedOffer.description}</p>
                    <p>Interest Rate: {selectedOffer.interestRate}</p>
                    <p>Tenure: {selectedOffer.tenure}</p>
                    <p>Amount: {selectedOffer.amount}</p>
                    <button onClick={() => handleApplyForLoan(selectedOffer.id)}>Apply Loan</button>
                </div>
            )}
        </div>
    );
};

export default GetOffers;
