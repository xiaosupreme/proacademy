import React, { Component } from 'react'
import CourseService from '../services/CourseService';

class UpdateCourseComponent extends Component {
    
    constructor(props) {
        super(props)

        this.state = {
            // step 2 **get id from props
            id: this.props.match.params.id,
            name: '',
            description: '',
            rating: '',
            price: ''
        }

        // step 4
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeDescriptionHandler = this.changeDescriptionHandler.bind(this);
        this.changeRatingHandler = this.changeRatingHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);


        // step 6
        this.updateCourse = this.updateCourse.bind()
    }

    componentDidMount(){
        CourseService.getCourseById(this.state.id).then( (res) =>{
            let course = res.data;
            this.setState({
                name: course.name,
                description: course.description,
                rating: course.rating,
                price: course.price
            });
        });
    }

    updateCourse = (e) => {
        e.preventDefault();
        let course = {
            name: this.state.name,
            description: this.state.description,
            rating: this.state.rating,
            price: this.state.price
        };
        console.log('course => ' + JSON.stringify(course));

        // step 7 **connect to backend
        CourseService.updateCourse(course, this.state.id).then(res => {
            this.props.history.push('/books');
        })
        
    }
    
    // step 3
    changeNameHandler = (event) => {
        this.setState({name: event.target.value});
    }

    changeDescriptionHandler = (event) => {
        this.setState({description: event.target.value});
    }

    changeRatingHandler = (event) => {
        this.setState({rating: event.target.value});
    }

    changePriceHandler = (event) => {
        this.setState({price: event.target.value});
    }

    // step 5
    cancel(){
        this.props.history.push('/books');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card-main col-md-6 offset-md-3 offset-md-3">
                            <br></br>
                                <h3><center>Update Course</center></h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label>Book Title:</label>
                                            <input placeholder="Title" name="name" className="form-control" 
                                                value={this.state.name} onChange={this.changeNameHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label>Author:</label>
                                            <input placeholder="Name" name="description" className="form-control" 
                                                value={this.state.description} onChange={this.changeDescriptionHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label>Rating:</label>
                                            <input placeholder="0-5" name="rating" className="form-control" 
                                                value={this.state.rating} onChange={this.changeRatingHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label>Price:</label>
                                            <input placeholder="$" name="price" className="form-control" 
                                                value={this.state.price} onChange={this.changePriceHandler}/>
                                        </div>
                                        <br></br>
                                        <br></br>

                                        <button className="btn-up" onClick={this.updateCourse}>Save</button>
                                        <button className="btn-delete" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}} >Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateCourseComponent;