import React, { Component } from 'react'

import CourseService from '../services/CourseService';

export default class ListCourseComponent extends Component {
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
                            <th className="table-list">Actions</th>
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
                                    <td className="table-list">
                                                 <button onClick={ () => this.editCourse(course.id)} className="btn-up">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCourse(course.id)} className="btn-delete">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCourse(course.id)} className="btn-view">View </button>
                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                
                </table>

              <center>
                <br></br> <br></br>
                <button className="btn-main" onClick={this.addCourse}>Add Book</button>
            <br></br><br></br>
            </center>
            </div>
        </div>
    )
  }
}
