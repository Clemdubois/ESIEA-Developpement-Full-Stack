export default function NewCategory(props) {

    // the inputs are controled by the state in App.js
   /* const catOptions = props.data.map(i => 
    <option id={i.id}> {i.name} </option>
    )*/

    return (
        <div className="newProduct__form">
            <h3 className="newProduct__title" >Add a Category</h3>
            <div className="newProduct__container">
                <label>Nom de la catégorie : {" "} </label>
                <input
                    className="newProduct__input" 
                    type="text"
                    placeholder="Give me a name..." 
                    name="name"
                    value={props.NewCategory.name}
                    onChange={props.handleChange} 
                />
            </div>
            
            
            {props.inputInvalid && <p>{props.inputInvalid}</p>}

            <button className="newCategory__submitButton" onClick={props.submitProduct}>New Categroy</button>
        </div>
    )
}

