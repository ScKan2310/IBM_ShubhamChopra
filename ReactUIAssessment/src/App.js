import React,{Component} from 'react';
import './App.css';
import Titles from "./Components/Titles"
import Form from './Components/Form';
import Brewery from './Components/Brewery';
class App extends Component {
  state = {
    name: undefined,
    city: undefined,
    webiste_url: undefined
  }

  getBrewery = async (e) => {
    const id = e.target.elements.Id.value
    e.preventDefault();
    if(id){
      const api_call = await fetch(`http://localhost:4949/${id}`)
      const data = await api_call.json();
      console.log(data);
      if(data.cod=="404"){
        this.setState({
          name: "cannot find",
          city: "cannot find",
          webiste_url: "cannot find"
        })
      }
      else{
        this.setState({
          name: data.name,
          city: data.city,
          website_url:data.webiste_url
        })
      }
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
                      <Form />
                      <Brewery
                        name={this.state.name}
                        city={this.state.city}
                        webiste_url={this.website_url} 
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
