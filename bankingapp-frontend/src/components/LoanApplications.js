import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './LoanApplications.css';
import { useNavigate } from 'react-router-dom';

const LoanApplications = () => {
    const [loanApplications, setLoanApplications] = useState([]);
    const navigate = useNavigate();
    useEffect(() => {
        const officeUserId = localStorage.getItem('officeUserId');
        if (!officeUserId) {
            navigate('/login-officeUser');
        } else {
            const fetchLoanApplications = async () => {
                try {
                    const response = await axios.get('http://localhost:8080/api/officers/applications');
                    setLoanApplications(response.data);
                } catch (error) {
                    console.error('Fetching loan applications failed', error);
                }
            };
            fetchLoanApplications();
        }
    }, []);

    const handleReview = async (id, status) => {
        try {
            const comments = status === 'Approved' ? 'Application approved' : 'Application denied';
            await axios.post(`http://localhost:8080/api/officers/applications/${id}/review`, { status, comments });
            setLoanApplications(loanApplications.map(app => app.id === id ? { ...app, status, comments } : app));
        } catch (error) {
            console.error(`Reviewing loan application (${status}) failed`, error);
        }
    }

    return (
        <div className="loan-applications">
            <h2>Loan Applications</h2>
            {loanApplications.length > 0 ? (
                <div className="cards">
                    {loanApplications.map((application) => (
                        <div key={application.id} className="card">
                            <p>Customer ID: {application.customerId}</p>
                            <p>Offer ID: {application.offerId}</p>
                            <p>Status: {application.status}</p>
                            <p>Comments: {application.comments}</p>
                            {application.status !== 'Approved' && (
                                <div className="buttons">
                                    <button onClick={() => handleReview(application.id, 'Approved')}>Approve</button>
                                    <button onClick={() => handleReview(application.id, 'Denied')}>Deny</button>
                                </div>
                            )}
                        </div>
                    ))}
                </div>
            ) : (
                <p>No loan applications found</p>
            )}
        </div>
    );
};

export default LoanApplications;
