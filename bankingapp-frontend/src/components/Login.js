import React, { useState } from 'react';
import { login } from '../services/customerService';
import { useNavigate } from "react-router-dom";
import '../css/Login.css';
const Login = () => {
    const [phoneNumber, setPhoneNumber] = useState('');
    const [dateOfBirth, setDateOfBirth] = useState('');

    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await login(phoneNumber, dateOfBirth);
            localStorage.setItem('phoneNumber', phoneNumber);

            navigate('/submit-kyc');
        } catch (error) {
            alert('Wrong Credential !');
            console.error('Login failed', error);
        }
    };

    return (
        <div className="login-container">
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Phone Number:</label>
                    <input
                        type="text"
                        value={phoneNumber}
                        onChange={(e) => setPhoneNumber(e.target.value)}
                    />
                </div>
                <div>
                    <label>Date of Birth:</label>
                    <input
                        type="date"
                        value={dateOfBirth}
                        onChange={(e) => setDateOfBirth(e.target.value)}
                    />
                </div>
                <button type="submit">Login</button>
            </form>
            <button className="alternate-button" onClick={() => navigate('/create-customer')}>Not Registered?</button>
            <button className="alternate-button" onClick={() => navigate('/login-officeUser')}>Office User! Login Here</button>
        </div>
    );
};

export default Login;
