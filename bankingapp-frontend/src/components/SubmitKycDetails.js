import React, { useState, useEffect } from 'react';
import { submitKycDetails } from '../services/customerService';
import { useNavigate } from 'react-router-dom';
import '../css/SubmitKycDetails.css';

const SubmitKycDetails = () => {
    const [phoneNumber, setPhoneNumber] = useState('');
    const [aadharNumber, setAadharNumber] = useState('');
    const [address, setAddress] = useState('');
    const [salary, setSalary] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        const storedPhoneNumber = localStorage.getItem('phoneNumber');
        if (storedPhoneNumber) {
            setPhoneNumber(storedPhoneNumber);
        } else {
            navigate('/');
        }
    }, [navigate]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const customer = await submitKycDetails(phoneNumber, aadharNumber, address, parseFloat(salary));
            console.log('KYC details submitted:', customer);
            navigate('/get-offers');
        } catch (error) {
            console.error('Failed to submit KYC details', error);
        }
    };

    return (
        <div className="submit-kyc-container">
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="aadharNumber"
                    value={aadharNumber}
                    onChange={(e) => setAadharNumber(e.target.value)}
                    placeholder="Aadhar Number"
                    required
                />
                <input
                    type="text"
                    name="address"
                    value={address}
                    onChange={(e) => setAddress(e.target.value)}
                    placeholder="Address"
                    required
                />
                <input
                    type="number"
                    name="salary"
                    value={salary}
                    onChange={(e) => setSalary(e.target.value)}
                    placeholder="Salary"
                    required
                />
                <button type="submit">Submit KYC Details</button>
            </form>
        </div>
    );
};

export default SubmitKycDetails;
