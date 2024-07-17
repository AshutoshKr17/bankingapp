import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/customers';

export const login = async (phoneNumber, dateOfBirth) => {
    return axios.post(`${API_BASE_URL}/login`, { phoneNumber, dateOfBirth });
};

export const createCustomer = async (phoneNumber, dateOfBirth) => {
    // return axios.post(`${API_BASE_URL}/create`, customer);
    try {
        const response = await axios.post(`${API_BASE_URL}/create`, { phoneNumber, dateOfBirth });
        console.log('Customer created successfully', response.data);
        return response.data;
    } catch (error) {
        console.error('Error creating customer', error);
        throw error;
    }
};

// export const submitKycDetails = async (customerId, kycDetails) => {
// return axios.post(`${API_BASE_URL}/${customerId}/kyc`, kycDetails);
// };

export const submitKycDetails = async (phoneNumber, aadharNumber, address, salary) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/${phoneNumber}/kyc`, {
            aadharNumber,
            address,
            salary
        });
        console.log('KYC details submitted successfully', response.data);
        return response.data;
    } catch (error) {
        console.error('Error submitting KYC details', error);
        throw error;
    }
};
export const getOffers = async (phoneNumber) => {
    return axios.get(`${API_BASE_URL}/${phoneNumber}/offers`);
};

export const applyForLoan = async (phoneNumber, offerId) => {
    return axios.post(`${API_BASE_URL}/${phoneNumber}/apply`, { offerId });

    // return axios.post(`${API_BASE_URL}/apply-loan`, { phoneNumber, offerId });
};
