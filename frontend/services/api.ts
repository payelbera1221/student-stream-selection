import axios from 'axios';

const api = axios.create({
  baseURL: process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080/api/students',
});

export const saveStudent = (data) => api.post('/save', data);
export const selectStream = (data) => api.post('/select-stream', data);
export const approveStudent = (data) => api.post('/approve', data);
export const makePayment = (data) => api.post('/payment', data);
export const updateRecheck = (data) => api.post('/recheck', data);
export const getAllStudents = () => api.get('/all');
export const getStudentById = (id) => api.get(`/${id}`);
export const searchByName = (name) => api.get(`/search/name/${name}`);
export const searchByStream = (stream) => api.get(`/search/stream/${stream}`);
export const searchByStatus = (status) => api.get(`/search/status/${status}`);
export const getManagementPending = () => api.get('/management-pending');
export const getPaymentPending = () => api.get('/payment-pending');
