import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import '../css/LoginOffice.css';

const LoginOffice = () => {
    const [userId, setUserId] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/officers/login', { userId, password });
            console.log(response.data);
            if (response.data) {
                localStorage.setItem('officeUserId', response.data.userId);
                navigate('/LoanApplications');
            } else {
                console.error('Login Failed');
            }
        } catch (error) {
            console.error('Login failed', error);
        }
    };

    return (
        <div className="login-office-container">
            <h2>Office User Login</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>User ID:</label>
                    <input
                        type="text"
                        value={userId}
                        onChange={(e) => setUserId(e.target.value)}
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>
                <button type="submit">Login</button>
                <button className="alternate-button" onClick={() => navigate('/')}>Not a Office User! Login Here</button>
            </form>
        </div>
    );
};

export default LoginOffice;
