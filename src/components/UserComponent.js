import React  from "react";
import UserService from "./UserService";

class UserComponent extends React.Component{

    constructor(props){
        super(props)
        this.state={
            users:[]
        }
    }

    componentDidMount() {
        UserService.getUsers()
            .then(response => {
                console.log(response); // Log the entire response
                console.log(response.data); // Log the data property
                 this.setState({ users: response.data  });
            })
            .catch(error => {
                // Handle the error
                console.error(error);
            });
    }
    
    

    render() {
        return (
            <div className="table-container">
                <h1 className="text-center">Users List</h1>
                <table className="custom-table">
                    <thead>
                        <tr>
                            <th>User First Name</th>
                            <th>User Last Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.users.map(user => (
                            <tr key={user.id}>
                                <td>{user.firstName}</td>
                                <td>{user.lastName}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        );
    }
    
}

export default UserComponent;