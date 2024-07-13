import React, { Component } from 'react'


class FeaturedAuthors extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }
    
    render() {
        return (
         
            <div className="ft">
                <center>Featured Authors</center>
                <br></br>
                <center>
                <table className="fatable">
                
                    <thead>
                       
                        <tr>
                        <th>
                           <img className="fa1" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fa1.jpg`} 
                            alt="logo"/></th>
                        <th>
                           <img className="fa2" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fa2.jpg`} 
                            alt="logo"/>
                        </th>
                            
                        <th>
                           <img className="fa3" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fa3.jpg`} 
                            alt="logo"/>
                        </th> 
                        <th>
                           <img className="fa4" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fa4.jpg`} 
                            alt="logo"/>
                        </th>   
                        <th>
                         <img className="fa5" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fa5.jpg`} 
                            alt="logo"/>
                            
                       </th>
                       </tr>
                       <tr>
                       <th><br></br>
                           Kate Cann <br></br>
                           Author of <br></br>Witch Crag
                           
                       </th>
                       <th><br></br>
                          Neil Gaiman <br></br>
                           Author of the <br></br>Sandman series
                       </th>
                       <th><br></br>
                           Deborah Blum <br></br>
                           Author of <br></br>Love at Goon Park
                       </th>
                       <th><br></br>
                          C.S Lewis <br></br>
                           Author of the<br></br> Narnia Series
                       </th>
                       <th><br></br>
                           Terry Pratchet <br></br>
                           Author of the <br></br>Discworld
                       </th>
                     
                      </tr>

                    </thead>
                </table>
                </center>
            </div>
        )
    }
}

export default FeaturedAuthors