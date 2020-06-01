import React from'react'

const Form = (props) => {
    return(
        <div>
            <form onSubmit={props.getBrewery}>
                <input type="text" id = "Id" name="Id" placeholder="Enter the id"></input>
                <button> Find Breweries</button>
            </form>
        </div>
    )
}

export default Form;