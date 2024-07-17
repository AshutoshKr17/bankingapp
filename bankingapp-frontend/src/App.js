import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './components/Login';
import CreateCustomer from './components/CreateCustomer';
import SubmitKycDetails from './components/SubmitKycDetails';
import GetOffers from './components/GetOffers';
import LoginOffice from './components/LoginOffice';
import LoanApplications from './components/LoanApplications';

const App = () => {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/create-customer" element={<CreateCustomer />} />
          <Route path="/submit-kyc" element={<SubmitKycDetails />} />
          <Route path="/get-offers" element={<GetOffers />} />
          <Route path="/login-officeUser" element={<LoginOffice />} />
          <Route path="/LoanApplications" element={<LoanApplications />} />
        </Routes>
      </BrowserRouter>
    </div >
  );
};

export default App;
