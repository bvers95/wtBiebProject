import NavigationMain from './NavigationMain'
import NavigationFoot from './NavigationFoot'

function Layout(props) {
  return (
    <div>
      <NavigationMain />
      <main className="bg-light py-5">
        {props.children}
      </main>
      <NavigationFoot />
    </div>
  );
}

export default Layout;