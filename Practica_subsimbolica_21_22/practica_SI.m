clear all;
entradas = xlsread('Humans.xlsx','entradas RNA')';
salidasDeseadas = xlsread('Humans.xlsx','Salidas RNA')';
arquitecturas = {[1 1],[3 1],[5 1],[10 1],[15 1],[5 3],[8 3],[8 5],[10 5]};

for j = 1:length(arquitecturas)
    arquitectura = arquitecturas{j};
    
    precisionEntrenamiento = [];
    precisionValidacion = [];
    precisionTest = [];
    
    for i=1:50
        
        rna = patternnet(arquitectura);
        rna.trainParam.showWindow = false;
        [rna, tr] = train(rna, entradas, salidasDeseadas);
        humansOuputs = sim(rna, entradas);
    
        precisionEntrenamiento(end+1) = 1-confusion(salidasDeseadas(:,tr.trainInd),humansOuputs(:,tr.trainInd));
        precisionValidacion(end+1)    = 1-confusion(salidasDeseadas(:,tr.valInd),humansOuputs(:,tr.valInd));
        precisionTest(end+1)          = 1-confusion(salidasDeseadas(:,tr.testInd), humansOuputs(:,tr.testInd));
        
    end 
    
    mediaPrecisionTest = mean(precisionTest);
    desviacionTipica = std(precisionTest);
    fprintf('Arquitectura [%d %d], Entrenamineto: %.2f%% (%.2f), Validacion: %.2f%% (%.2f), Test: %.2f%% (%.2f)\n',arquitectura, ...
            mean(precisionEntrenamiento), std(precisionEntrenamiento), mean(precisionValidacion), ...
            std(precisionValidacion), mean(precisionTest), std(precisionTest));
   
end
