import { Link } from "react-router-dom";

const Logo = ({brandName}) => {
  return <Link to="/" className="font-extrabold text-3xl">{brandName}</Link>;
};

export default Logo;
