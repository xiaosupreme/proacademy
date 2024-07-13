import React, { Component } from 'react'

import CourseService from '../services/CourseService';

export default class Home extends Component {
    constructor(props) {
        super(props)

        this.state = {
            courses: []
        }

        this.addCourse = this.addCourse.bind(this);
        this.editCourse = this.editCourse.bind(this);
        this.deleteCourse = this.deleteCourse.bind(this);
    }

    componentDidMount(){
        CourseService.getCourses().then((res) => {
            this.setState({courses: res.data})
        });
    }

    // Methods

    addCourse(){
        this.props.history.push('/add-book');
    } 

    editCourse(id){
        this.props.history.push(`/update-book/${id}`);
    }

    viewCourse(id){
        this.props.history.push(`/view-book/${id}`);
    }

    deleteCourse(id){
        CourseService.deleteCourse(id).then( res => {
            this.setState({courses: this.state.courses.filter(course => course.id !== id)});
        });
    }


    // Content
  
    render() {
    return (
        <div>
            <br></br>
            <h2 className="text-center">Book Registry</h2>
            <br></br>

            {/* button for adding course */}
            
        
            <div className="row">
                <table className="table-list">

                    <thead className="table-list">
                        <tr className="table-list">
                            <th className="table-list">Book Name</th>
                            {/* <th>Course Instructor</th> */}
                            <th className="table-list">Author</th>
                            <th className="table-list">Rating</th>
                            <th className="table-list">Price</th>
                        </tr>
                    </thead>

                    <tbody className="table-list">
                        {
                            this.state.courses.map(
                                course =>
                                <tr key = {course.id}>
                                    <td className="table-list">{course.name}</td>
                                    {/* <td>{course.instructor.first_name} {course.instructor.last_name}</td> */}
                                    <td className="table-list">{course.description}</td>
                                    <td className="table-list">{course.rating} out of 5</td>
                                    <td className="table-list">${course.price}</td>
                                </tr>
                            )
                        }
                    </tbody>
                
                </table>

              <center>
                <br></br> <br></br>
            
            <br></br><br></br>
            </center>
            </div>
        </div>
    )
  }
}