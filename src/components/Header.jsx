import { Link } from "react-router-dom";
import Button from "./ui/Button";
import Logo from "./Logo";

function Header() {
    return (
        <div className="flex items-center justify-between px-5 py-4">
            <div className="w-fit">
                <Logo brandName="Todofy" />
            </div>
            <div className="w-fit">
                <Link to="/auth">
               <Button btnText="Login" className="btn" /> 
                </Link>
            </div>
        </div>
    )
}
export default Header;