import { useState } from "react";
import Button from "../components/ui/Button";
import Input from "../components/ui/Input";

function Auth() {
    const [authMode, setAuthMode] = useState("register");
    function toggleAuthMode() {
        setAuthMode((prevMode) => {
            if (prevMode === "register") {
                return "login";
            } else {
                return "register";
            }
        });
    }
    return (
        <div className="w-screen flex items-center justify-center h-screen bg-gray-100">
          <div className="bg-white rounded-xl drop-shadow-xl px-6 py-5">
            <form>
                <div className="w-full text-left py-2">
                    <h2 className="text-3xl font-extrabold">
                        {
                            authMode === "register" ? "Register" : "Login"
                        }
                    </h2>
                </div>
                <div className="flex mt-5 flex-col space-y-5 items-center">
                    {authMode === "register" && <Input type="text" placeholder="Username" name="username" label="Username" />}
                    <Input type="email" placeholder="Email" name="email" label="Email" />
                    <Input type="password" placeholder="Password" name="password" label="Password" />
                    <div>
                        <p>
                            <span>
                                {
                                    authMode === "register" ? "Already have an account?" : "Don't have an account?"
                                }
                                </span> <span className="text-blue-500 cursor-pointer" onClick={toggleAuthMode}>
                                    {
                                        authMode === "register" ? "Login" : "Register"
                                    }
                                </span>
                        </p>
                    </div>
                    <Button btnText="Login" className="btn" />
                </div>
            </form>
            </div>  
        </div>
    )
}
export default Auth;