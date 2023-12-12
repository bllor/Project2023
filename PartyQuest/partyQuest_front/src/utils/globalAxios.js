import axios from "axios";

/**
 * 인증 되기 전에 사용하는 axios
 * @type {axios.AxiosInstance}
 */
export const axiClient = axios.create({
  baseURL: import.meta.env.VITE_APP_BASE_URL,
});

/**
 * 인증 후 사용하는 axios
 * @type {axios.AxiosInstance}
 */
export const axiValid = axios.create({
  baseURL: import.meta.env.VITE_APP_BASE_URL,
  withCredentials: true,
});

export const getValidatedAxios = (myAuthorization) => {
  return axios.create({
    baseURL: import.meta.env.VITE_APP_BASE_URL,
    headers : {"Authorizaton": myAuthorization},
    withCredentials: true,
  })
}

