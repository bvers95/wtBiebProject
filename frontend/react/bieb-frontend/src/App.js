import { Route , Routes } from 'react-router-dom';

import BooksOverview from './pages/BooksOverview';
import BookDetails from './pages/BookDetails';
import NotFound from './pages/NotFound';

import Layout from './layout/Layout';

function App() {
  return (
    <Layout>
      <Routes>
        <Route path='/' 
          element={
            <BooksOverview />
          } exact
        />
        <Route path='/book' 
          element={
            <BookDetails />
          }
        />
        <Route path='*' 
          element={
            <NotFound />
          }
        />
      </Routes>
    </Layout>
  );
}

export default App;
