function Input({type, placeholder, name, label}) {
    return (
        <div className="flex flex-col space-y-4">
            <label className="fone-bold text-lg" htmlFor={name}>
                {label}
            </label>
            <input
                type={type}
                name={name}
                id={name}
                placeholder={placeholder}
                className="input" />
        </div>
    )
}

export default Input