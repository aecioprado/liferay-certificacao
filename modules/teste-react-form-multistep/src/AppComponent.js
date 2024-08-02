import React from 'react';
import ReactDOM from 'react-dom';
import ClayMultiStepNav from '@clayui/multi-step-nav';
import { useState, useEffect } from 'react';
import ClayButton from '@clayui/button';
import TipoSolicitacao from './components/forms/TipoSolicitacao';
import IdentificacaoInstituicao from './components/forms/IdentificacaoInstituicao';
import ContatoInstituicao from './components/forms/ContatoInstituicao';
import IdentificacaoSolicitante from './components/forms/IdentificacaoSolicitante';
import ClayForm from '@clayui/form';

//hooks
import useFormStep from './hooks/useFormStep';

export default function AppComponent(props) {

  const formData = {
    "isPlantaoJudiciario": null,
    "CRAAI": "",
    "PromotoriaJustica": "",
    "isAdolescenteApreendido": null,
    "dataOitiva": "",
    "nomeAdvogado": "",
    "numeroOABMatricula": "",
    "nomeResponsavelAdolescente": ""
  }

  const [data, setData] = useState(formData);

  const handleFieldUpdate = (key, value) => {
    console.log("data", key, value)
    setData((prevState) => {
      const updatedData = { ...prevState, [key]: value };
      console.log("dataUpdated inside setState", updatedData);
      return updatedData;
    });
  }

  useEffect(() => {
    console.log("State updated:", data);
  }, [data]);

  /* steps */
  const stepsComponents = [
    <TipoSolicitacao data={data} handleFieldUpdate={handleFieldUpdate} />,
    <IdentificacaoSolicitante data={data} handleFieldUpdate={handleFieldUpdate} />,
    <IdentificacaoInstituicao data={data} handleFieldUpdate={handleFieldUpdate} />,
    <ContatoInstituicao data={data} handleFieldUpdate={handleFieldUpdate} />]

  const { currentStep, currentComponent, handleStepUpdate: changeStep, isFirtStep, isLastStep } = useFormStep(stepsComponents);

  const steps = [
    {
      subTitle: "Tipo de solicitação"
    },
    {
      subTitle: "Identificação do solicitante"
    },
    {
      subTitle: "Identificação da instituição"
    },
    {
      subTitle: "Contato na instituição"
    }
  ];

  const handleSubmitForm = () => {
    console.log("Formulário enviado");
    // Lógica para envio do formulário
  };

  return (
    <>
      <ClayForm onSubmit={(e) => {

        if (isLastStep) {
          handleSubmitForm();
        } else {
          changeStep(currentStep + 1, e);
        }

      }}>
        <ClayMultiStepNav>
          {steps.map(({ subTitle }, i) => {
            const complete = currentStep > i;

            return (
              <ClayMultiStepNav.Item
                /* Fica ativo o step que o currentStep for igual ao index */
                active={currentStep === i}
                expand={i + 1 !== steps.length}
                key={i}
                state={complete ? "complete" : undefined}
              >
                <ClayMultiStepNav.Divider />
                <ClayMultiStepNav.Indicator
                  complete={complete}
                  label={1 + i}
                  onClick={null}
                  subTitle={subTitle}
                />
              </ClayMultiStepNav.Item>
            );
          })}
        </ClayMultiStepNav>

        {/* componente atual */}
        {currentComponent}

        <div className="btn-row">
          {!isFirtStep && (
            <ClayButton className="mr-2 mt-4" displayType="primary" onClick={() => { changeStep(currentStep - 1) }}>
              Voltar
            </ClayButton>
          )}

          <ClayButton displayType="primary" type="submit" className="mt-4">
            {isLastStep ? 'Enviar' : 'Avançar'}
          </ClayButton>

        </div>
      </ClayForm>
    </>

  );
}
