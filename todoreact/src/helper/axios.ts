import axios from "axios";

const baseURL = "https://jsonplaceholder.typicode.com/";

const headers = {
  "Accept-Language":"tr-TR",
  "Content-Type":"application/json"
};


const configuration = {
  baseURL,
  headers
};

const axiosInstance = axios.create({...configuration});

axiosInstance.interceptors.request.use(config => {
  if (localStorage.token) {
    try {
      config.headers.Authorization = `Bearer ${
        JSON.parse(localStorage.token).accessToken
      }`;
    } catch (error) {}
  }
  return config;
});

/////***********************AXÄ°OS*******************************/////////////////////

export const axiosGet = async  (url:string, headers?:any, params?:any) => {
  const response = await axiosInstance.get(url,{
    headers,
    params
  });
  return response;
}

export const axiosPost = async  (url:string ,data?:any ,headers?:any, params?:any) => {
  const response = await axiosInstance.post(url,data,{
    headers,
    params
  });
  return response;
}

