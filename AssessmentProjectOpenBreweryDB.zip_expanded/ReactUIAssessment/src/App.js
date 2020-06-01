import React,{Component} from 'react';
import './App.css';
import Titles from "./Components/Titles"
import Form from './Components/Form';
import Brewery from './Components/Brewery';

class App extends Component {
  state = {
    id : undefined,
    name: undefined,
    city: undefined,
    state : undefined,
    website_url: undefined
  }

  getBrewery = async (e) => {
    const id = e.target.elements.Id.value
    e.preventDefault();
    console.log(id);
    if(id){
      const api_call = await fetch(`http://localhost:5050/${id}`)
      const data = await api_call.json();
      console.log(data);
      // if(data.cod=="404"){
      //   this.setState({
      //     name: "cannot find",
      //     city: "cannot find",
      //     webiste_url: "cannot find"
      //   })
      // }
      // else{
        this.setState({
            id : data.id,
            name: data.name,
            city: data.city,
            state : data.state,
            website_url:data.website_url
        });
        console.log(id);
        console.log(data);
        console.log(typeof data);
    }

  }

  render(){
    return (
        <div>
          <div className="wrapper">
            <div className="main">
              <div className="container">
                <div className="row">
                  <div className="col-xs-5 title-container">
                    <Titles />
                    <div className="col.xs.7 form-container">
                      <Form getBrewery = {this.getBrewery}/>
                      <Brewery
                        id={this.state.id}
                        name={this.state.name}
                        city={this.state.city}
                        state={this.state.state}
                        website_url={this.state.website_url} 
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      )
  }
  
}

export default App;
