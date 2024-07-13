import logo from "./logo.svg";
import "./App.css";

import { BrowserRouter as Router, Route, Switch, withRouter } from "react-router-dom";

import ListCourseComponent from "./components/ListCourseComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import CreateCourseComponent from "./components/CreateCourseComponent";
import UpdateCourseComponent from "./components/UpdateCourseComponent";
import ViewCourseComponent from "./components/ViewCourseComponent";
import FeaturedAuthors from "./components/FeaturedAuthors";
import FeaturedBooks from "./components/FeaturedBooks";
import Home from "./components/Home";

function App() {
  return (
    
      <div>
      <Router>

        <HeaderComponent />

        <div className="container">
          <Switch>
            <Route exact path="/" component={Home}></Route>
            <Route path="/books" component={ListCourseComponent}></Route>
            <Route path="/add-book" component={CreateCourseComponent}></Route>
            <Route path="/update-book/:id" component={UpdateCourseComponent}></Route>
            <Route path="/view-book/:id" component={ViewCourseComponent}></Route>
            <Route path="/featured_authors" component={FeaturedAuthors}></Route>
            <Route path="/featured_books" component={FeaturedBooks}></Route>
          </Switch>
        </div>
<br></br><br></br><br></br>
        <FooterComponent />
      </Router>
    </div>
    
  );
}

export default App;
