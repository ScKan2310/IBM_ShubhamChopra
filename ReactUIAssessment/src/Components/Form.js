import React from'react'

const Form = (props) => {
    return(
        <div>
            <form onSubmit={props.getBrewery}>
                <input type="number" name="id" placeholder="Enter the id"></input><br/>
                <button>Find Breweries</button>
            </form>
        </div>
    )
}

export default Form;