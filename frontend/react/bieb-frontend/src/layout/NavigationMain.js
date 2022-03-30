import { Navbar, Nav, Container, Dropdown, DropdownButton } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap'

function NavigationMain() {
  return (
    <Navbar bg="dark" variant="dark">
      <Container>
        <LinkContainer to="/">
          <Navbar.Brand>
            <img
              alt="Home"
              src="/logo.svg"
              height="100"
              className="d-inline-block align-top"
            />
          </Navbar.Brand>
        </LinkContainer>
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ms-auto">
            <DropdownButton title="Menu" id="basic-nav-dropdown" align="end" variant="outline-light"> 
              <Dropdown.Header>Menu</Dropdown.Header>
              <LinkContainer to="/gebruikers">
                <Dropdown.Item>Gebruikers</Dropdown.Item>
              </LinkContainer>
              <LinkContainer to="/leningen">
                <Dropdown.Item>Leningen</Dropdown.Item>
                </LinkContainer>
              <LinkContainer to="/">
                <Dropdown.Item>Boeken</Dropdown.Item>
                </LinkContainer>
              <LinkContainer to="/tags">
                <Dropdown.Item >Tags</Dropdown.Item>
                </LinkContainer>
              <Dropdown.Divider />
              <LinkContainer to="/logout">
                <Dropdown.Item>Logout</Dropdown.Item>
                </LinkContainer>
            </DropdownButton>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NavigationMain;
