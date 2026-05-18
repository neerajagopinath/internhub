import axios from "axios";

const API_URL =
    "http://localhost:8080/api/interns";

export async function getAllInterns(
    page = 0,
    size = 5,
    sortBy = "id",
    direction = "asc"
) {

    const response =
        await axios.get(
            `${API_URL}?page=${page}&size=${size}&sortBy=${sortBy}&direction=${direction}`
        );

    return response.data;
}

export async function searchInterns(
    keyword,
    page = 0,
    size = 5,
    sortBy = "id",
    direction = "asc"
) {

    const response =
        await axios.get(
            `${API_URL}/search?keyword=${keyword}&page=${page}&size=${size}&sortBy=${sortBy}&direction=${direction}`
        );

    return response.data;
}

export async function createIntern(
    internData
) {

    const response =
        await axios.post(
            API_URL,
            internData
        );

    return response.data;
}

export async function updateIntern(
    id,
    internData
) {

    const response =
        await axios.put(
            `${API_URL}/${id}`,
            internData
        );

    return response.data;
}

export async function deleteIntern(id) {

    const response =
        await axios.delete(
            `${API_URL}/${id}`
        );

    return response.data;
}