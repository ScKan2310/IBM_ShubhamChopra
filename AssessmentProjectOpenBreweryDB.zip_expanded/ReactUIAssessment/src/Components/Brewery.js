import React from 'react'

const Brewery = (props) => {
    return(
        <div className="brewery_info">
            
            {
                props.name && 
                <p className="brewery_key">Name :  
                <span className="brewery_value"> {props.name}</span>
                </p>
            }
            {
                props.city && 
                <p className="brewery_key">City :  
                <span className="brewery_value"> {props.city}</span>
                </p>
            }
            {
                props.state && 
                <p className="brewery_key">State :  
                <span className="brewery_value"> {props.state}</span>
                </p>
            }
            {
                props.website_url && 
                <p className="brewery_key">Website Info :  
                <span className="brewery_value"> {props.website_url}</span>
                </p>
            }
        </div>
    )
}

export default Brewery;