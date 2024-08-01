import React, { useState } from 'react'

/* Os steps são definidos no AppComponent */
const useFormStep = (steps) => {

    const [currentStep, setCurrentStep] = useState(0);
    console.log("currentStep", currentStep);

    const handleStepUpdate = (i, e) => {

        console.log("index", i);

        if (e) {
            e.preventDefault();
        }

        /* Verifica se o indice é menor que zero ou se é maior que o limite do array ou se já está no ultimo step */
        if (i < 0 || i >= steps.length) {
            return;
        } else {
            setCurrentStep(i);
        }

    }

    return {
        currentStep,
        currentComponent: steps[currentStep],
        handleStepUpdate,
        isFirtStep: currentStep === 0 ? true : false,
        isLastStep: currentStep + 1 === steps.length ? true : false
    }
}

export default useFormStep
