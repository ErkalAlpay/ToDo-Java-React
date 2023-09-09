import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Deneme from './Main';
import TodoRouter from './TodoRouter';

function App() {
  return (
    
    <BrowserRouter>
      <TodoRouter/>
    </BrowserRouter>
  );
}

export default App;
