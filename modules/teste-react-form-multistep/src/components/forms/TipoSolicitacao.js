import React from 'react'
import { ClayRadio, ClayRadioGroup } from '@clayui/form';
import { ClaySelect } from '@clayui/form';
import ClayDatePicker from '@clayui/date-picker';
import ClayForm, { ClayInput } from '@clayui/form';

const TipoSolicitacao = ({ data, handleFieldUpdate }) => {

  const options = [
    {
      label: "Option 1",
      value: "1"
    },
    {
      label: "Option 2",
      value: "2"
    }
  ];


  return (
    <>
      <h2>Tipo de Solicitação</h2>

      <h3>A oitiva é realizada em plantão judiciário?</h3>
      <ClayRadioGroup
        defaultValue={data.isPlantaoJudiciario === true ? "Sim" : "Nao"}
        onChange={(value) => handleFieldUpdate("isPlantaoJudiciario", value === "Sim" ? true : false)}
        inline
      >
        <ClayRadio label="Sim" value="Sim" />
        <ClayRadio label="Não" value="Nao" />
      </ClayRadioGroup>


      <div className="container-fluid">
        <div className="row">
          <div className="col-4">
            <ClaySelect aria-label="Select Label" id="mySelectId">
              {options.map(item => (
                <ClaySelect.Option
                  key={item.value}
                  label={item.label}
                  value={item.value}
                />
              ))}
            </ClaySelect>
          </div>
          <div className="col">
            <ClaySelect aria-label="Select Label" id="mySelectId">
              {options.map(item => (
                <ClaySelect.Option
                  key={item.value}
                  label={item.label}
                  value={item.value}
                />
              ))}
            </ClaySelect>
          </div>
        </div>
      </div>

      <h3>O adolescente está apreendido?</h3>
      <ClayRadioGroup
        defaultValue="Nao"
        inline
      >
        <ClayRadio label="Sim" value="Sim" />
        <ClayRadio label="Não" value="Nao" />
      </ClayRadioGroup>


      <h3>Data da Oitiva</h3>
      <div className="container-fluid">
        <div className="row">
          <div className="col-2">
            <ClayDatePicker
              onChange={null}
              placeholder="YYYY-MM-DD"
              spritemap={null}
              value={null}
              years={{
                end: 2024,
                start: 1997
              }}
            />
          </div>
        </div>
      </div>


      <div className="container-fluid">
        <div className="row">
          <div className="col">
            <label htmlFor="basicInputText">Name</label>
            <ClayInput
              id="basicInputText"
              placeholder="Insert your name here"
              type="text"
            />
          </div>
          <div className="col-4">
            <label htmlFor="basicInputText">Name</label>
            <ClayInput
              id="basicInputText"
              placeholder="Insert your name here"
              type="text"
            />
          </div>
        </div>
        <div className="row">
          <div className="col">
            <label htmlFor="basicInputText">Name</label>
            <ClayInput
              id="basicInputText"
              placeholder="Insert your name here"
              type="text"
            />
          </div>
        </div>
      </div>




    </>
  )
}

export default TipoSolicitacao
