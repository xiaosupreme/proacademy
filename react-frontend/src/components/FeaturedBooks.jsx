import React, { Component } from 'react'

class FeaturedBooks extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
         
            <div className="ft">
                <center>Featured Books</center>
                <br></br>
<center>
                <table className="fatable">
                
                    <thead>
                       
                    <tr>
                       <th><br></br>
                           Witch Crag <br></br><br></br>
                           
                           
                       </th>
                       <th><br></br>
                         The Sandman Book one <br></br><br></br>
                           
                       </th>
                       <th><br></br>
                         Love at Goon Park <br></br><br></br>
                          
                       </th>
                       <th><br></br>
                          The Chronicles of Narnia 4 <br></br><br></br>
                           
                       </th>
                       <th><br></br>
                           Small Gods <br></br><br></br>
                         
                       </th>
                     
                      </tr>
                        <tr>
                        <th>
                           <img className="fb" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fb1.jpg`} 
                            alt="logo"/></th>
                        <th>
                           <img className="fb" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fb2.jpg`} 
                            alt="logo"/>
                        </th>
                            
                        <th>
                           <img className="fb" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fb3.jpg`} 
                            alt="logo"/>
                        </th> 
                        <th>
                           <img className="fb" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fb4.jpg`} 
                            alt="logo"/>
                        </th>   
                        <th>
                         <img className="fb" 
                             src={`${process.env.PUBLIC_URL}/assets/images/fb5.jpg`} 
                            alt="logo"/>
                            
                       </th>
                       </tr>
                       <tr>
                       <th><br></br>
                           Written by Kate Cann <br></br>
                           
                           
                       </th>
                       <th><br></br>
                           Written by Neil Gaiman <br></br>
                           
                       </th>
                       <th><br></br>
                          Written by Deborah Blum<br></br>
                          
                       </th>
                       <th><br></br>
                           Written by C.S Lewis <br></br>
                           
                       </th>
                       <th><br></br>
                           Written by Terry Pratchett <br></br>
                         
                       </th>
                     
                      </tr>

                    </thead>
                </table>
              </center>
            </div>
        )
    }
}

export default FeaturedBooks