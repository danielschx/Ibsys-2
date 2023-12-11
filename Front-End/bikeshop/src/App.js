import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import HomePage from "./pages/home";
import FileUpload from "./pages/UploadFile";
import Simulation from "./pages/simulation/Simulation";

function App() {
  return (
    <Router>
      <Routes>
        {/* <Route path="/" element={<HomePage />} /> */}
        {/* <Route path="/upload" element={<FileUpload />} /> */}
        <Route path="/" element={<FileUpload />} />
        <Route path="/simulation" element={<Simulation />} />
      </Routes>
    </Router>
  );
}

export default App;
