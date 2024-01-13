import axios from 'axios'

const USER_REST_API_URL= "http://localhost:8000/persons/getperson";

class UserService{

    getUsers(){
            return axios.get(USER_REST_API_URL);
    }
}

export default new UserService();

