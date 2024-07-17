import React, { useState } from 'react';
import { createCustomer } from '../services/customerService';
import { useNavigate } from 'react-router-dom';

const CreateCustomer = () => {
    const [phoneNumber, setPhoneNumber] = useState('');
    const [dateOfBirth, setDateOfBirth] = useState('');
    const navigate = useNavigate();
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await createCustomer(phoneNumber, dateOfBirth);
            alert('Customer Created successfully!');
            navigate('/submit-kyc');
        } catch (error) {
            console.error('Customer creation failed', error);
        }
    };

    return (
        <div>
            <h2>Create Customer</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="phoneNumber"
                    value={phoneNumber}
                    onChange={(e) => setPhoneNumber(e.target.value)}
                    placeholder="Phone Number"
                    required
                />
                <input
                    type="date"
                    name="dateOfBirth"
                    value={dateOfBirth}
                    onChange={(e) => setDateOfBirth(e.target.value)}
                    placeholder="Date of Birth"
                    required
                />
                <button type="submit">Create Customer</button>
            </form>
            <button onClick={() => navigate('/')}>Already a User! Login</button>
        </div>
    );
};

export default CreateCustomer;
