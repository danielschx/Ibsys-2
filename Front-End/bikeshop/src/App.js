import "./App.css";
import "./pages/home";
import FileUpload from "./pages/UploadFile";

function App() {
  return (
    // <div className="container">
    //   <ToastContainer />
    //   <Routes>
    //     <Route path="/" element={<HomePage />} />
    //     <Route path="/upload" element={<FileUpload />} />
    //   </Routes>
    // </div>
    <FileUpload />
  );
}

export default App;
