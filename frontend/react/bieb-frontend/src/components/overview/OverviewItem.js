import { Card, Col, Button } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';

import BookCover from '../cover/BookCover';

function OverviewItem (props) {
  return (
    <Col>
      <Card>
        <BookCover image={props.coverUrl} isbn={props.isbn}/>
        <Card.Body className="text-center">
          <Card.Title className="mt-1">{props.title}</Card.Title>
          <LinkContainer to={"/book?isbn="+props.isbn}>
            <Button variant="primary" className="mt-2 mb-3">Bewerken</Button>
          </LinkContainer>
        </Card.Body>
      </Card>
    </Col>

  );
}

export default OverviewItem;
