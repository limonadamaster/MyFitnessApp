import BaseService from "./BaseService";


class CalorieService extends BaseService{

constructor(apiUrl){
    super(apiUrl);
}

getUsers(){
    return this.getUsers('users')
}

}

export default CalorieService;