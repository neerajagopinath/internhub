import api from "../utils/api";

export const getAllInterns = async () => {
  const response = await api.get("/api/interns");

  return response.data;
};

export const createIntern = async (internData) => {
  const response = await api.post(
    "/api/interns",
    internData
  );

  return response.data;
};

export const deleteIntern = async (id) => {
  const response = await api.delete(
    `/api/interns/${id}`
  );

  return response.data;
};

export const searchInterns = async (name) => {
  const response = await api.get(
    `/api/interns/search?name=${name}`
  );

  return response.data;
};

export const updateIntern = async (
  id,
  internData
) => {

  const response = await api.put(
    `/api/interns/${id}`,
    internData
  );

  return response.data;

};