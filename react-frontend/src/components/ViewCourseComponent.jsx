import React, { Component } from 'react'
import CourseService from '../services/CourseService'

class ViewCourseComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            course: {}
        }
    }

    componentDidMount(){
        CourseService.getCourseById(this.state.id).then( res => {
            this.setState({course: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card-main col-md-6 offset-md-3">
                <br></br>
                    <h3 className = "text-center"> Review Book Details</h3>
                    <div className = "card-body">
                        
                        <div className = "row">
                            <label>Book Title:</label>
                            <div> { this.state.course.name }</div>
                        </div>

                        <div className = "row">
                            <label>Author: </label>
                            <div> { this.state.course.description }</div>
                        </div>

                        <div className = "row">
                            <label>Rating:</label>
                            <div> { this.state.course.rating } out of 5</div>
                        </div>

                        <div className = "row">
                            <label>Book Price:</label>
                            <div> ${ this.state.course.price }</div>
                        </div>

                    </div>

                </div>
            </div>
        )
    }
}

export default ViewCourseComponent;