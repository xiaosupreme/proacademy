import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            
            <div>
                <header>
                <div class="jumbotron">

                        <div class="text-center">
                        <br></br> 

                        <h1>Library Management System</h1> 
                          
                        <br></br>
                        <br></br>
            

                     </div>
                    </div>

                    <div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
       
                        
      </button>

    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
        
      <ul class="nav navbar-nav" >
    
         <li><a href="/">Home</a></li>
        <li><a href="/featured_authors">Feaured Authors</a></li>
        <li><a href="featured_books">Featured Books</a></li>		
        <li><a href="/books">Admin Panel</a></li>
        
      </ul>
    
    </div>
  </div>
</nav>
                    </div>
                </header>
            </div>
        )
    }
}

export default HeaderComponent