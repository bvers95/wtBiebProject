import { Row } from 'react-bootstrap';

import OverviewItem from "./OverviewItem";

function OverviewList(props) {
  return (
    <section>
      <h4 className="mb-4">WT Bieb Collectie</h4>
      <Row xs={1} md={2} lg={3} xl={4} className="g-4">
        {props.books.map(
          book => {
            return (
              <OverviewItem
                isbn={book.isbn}
                title={book.title}
                coverUrl={book.coverUrl}
              />
            )
          }
        )}
      </Row>
    </section>
  );
}

export default OverviewList;
