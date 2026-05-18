import api from "../utils/api";

export const signupUser = async (userData) => {
  const response = await api.post(
    "/api/auth/signup",
    userData
  );

  return response.data;
};

export const loginUser = async (loginData) => {
  const response = await api.post(
    "/api/auth/login",
    loginData
  );

  return response.data;
};