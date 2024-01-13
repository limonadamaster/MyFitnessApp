// BaseService.js
import axios from 'axios';

class BaseService {
    constructor(apiUrl) {
        this.apiUrl = apiUrl;
    }

    get(url) {
        return axios.get(`${this.apiUrl}/${url}`);
    }
}

export default BaseService;
