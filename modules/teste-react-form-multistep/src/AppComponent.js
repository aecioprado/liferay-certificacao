import React from 'react';
import ReactDOM from 'react-dom';
import ClayMultiStepNav from '@clayui/multi-step-nav';
import { useState } from 'react';
import ClayButton from '@clayui/button';
import TipoSolicitacao from './components/forms/TipoSolicitacao';
import IdentificacaoInstituicao from './components/forms/IdentificacaoInstituicao';
import ContatoInstituicao from './components/forms/ContatoInstituicao';
import IdentificacaoSolicitante from './components/forms/IdentificacaoSolicitante';
import ClayForm from '@clayui/form';

//hooks
import useFormStep from './hooks/useFormStep';

export default function AppComponent(props) {

  /* steps */
  const stepsComponents = [<TipoSolicitacao />, <IdentificacaoSolicitante />, <IdentificacaoInstituicao />, <ContatoInstituicao />]

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
            <ClayButton className="mr-2" displayType="primary" onClick={() => { changeStep(currentStep - 1) }}>
              Voltar
            </ClayButton>
          )}

          <ClayButton displayType="primary" type="submit">
            {isLastStep ? 'Enviar' : 'Avançar'}
          </ClayButton>

        </div>
      </ClayForm>
    </>

  );
}
