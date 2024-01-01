import "./App.css";
import { Route, Routes } from "react-router-dom";
import Navbar from "./components/navbar/Navbar";
import Home from "./pages/home/Home";
import Simulation from "./pages/simulation/Simulation";
import Overview from "./pages/overview/Overview";
import FileUpload from "./pages/fileupload/FileUpload";
import { ToastContainer } from "react-toastify";

export default function App() {
  return (
    <>
      <Navbar />
      <div className="container">
        <ToastContainer />
        <Routes>
          {/* <Route path="/" element={<Home />} /> */}
          <Route path="/simulation" element={<Simulation />} />
          <Route path="/overview" element={<Overview />} />
          <Route path="/" element={<FileUpload />} />
        </Routes>
      </div>
    </>
  );
}
