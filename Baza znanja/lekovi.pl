%lekovi za odredjene bolesti pluca i ucestalost njihovog koriscenja(procenat)

%asthma
medication(asthma,albuterol,100).
medication(asthma,prednisone,82).
medication(asthma,montelukast,78).
medication(asthma,ipratropium,68).
medication(asthma,levalbuterol,51).
medication(asthma,terbutaline,10).

%pneumonia
medication(pneumonia,azithromycin,100).
medication(pneumonia,ceftriaxone,95).
medication(pneumonia,moxifloxacin,80).
medication(pneumonia,zosyn,66).
medication(pneumonia,robitussin_ac,43).
medication(pneumonia,cefepime,39).
medication(pneumonia,ceftazidime, 22).
medication(pneumonia,piperacillin,7).

%chronic obstructive pulmonary disease
medication(chronic_obstructive_pulmonary_disease,azithromycin,100).
medication(chronic_obstructive_pulmonary_disease,combivent,83).
medication(chronic_obstructive_pulmonary_disease,tiotropium,78).
medication(chronic_obstructive_pulmonary_disease,guaifenesin,71).
medication(chronic_obstructive_pulmonary_disease,levalbuterol,67).
medication(chronic_obstructive_pulmonary_disease,clarithromycin,41).
medication(chronic_obstructive_pulmonary_disease,theophylline,14).

%acute bronchitis
medication(acute_bronchitis,azithromycin,100).
medication(acute_bronchitis,guaifenesin,73).
medication(acute_bronchitis,benzonatate,54).
medication(acute_bronchitis,robitussin_ac,49).
medication(acute_bronchitis,clarithromycin,43).
medication(acute_bronchitis,dextromethorphan,9).

%simptomi i dijagnoze

%cough
symptom_diagnose(cough,asthma,17).
symptom_diagnose(cough,chronic_obstructive_pulmonary_disease,12).
symptom_diagnose(cough,pneumonia,7).
symptom_diagnose(cough,acute_bronchitis,2).

%shortness of breath
symptom_diagnose(shortness_of_breath,chronic_obstructive_pulmonary_disease,15).
symptom_diagnose(shortness_of_breath,asthma,13).
symptom_diagnose(shortness_of_breath,pneumonia,7).
symptom_diagnose(shortness_of_breath,acute_bronchitis,2).

%nasal congestion
symptom_diagnose(nasal_congestion,chronic_obstructive_pulmonary_disease,9).
symptom_diagnose(nasal_congestion,asthma,6).
symptom_diagnose(nasal_congestion,acute_bronchitis,4).
symptom_diagnose(nasal_congestion,pneumonia,0).

%fever
symptom_diagnose(fever,pneumonia,5).
symptom_diagnose(fever,chronic_obstructive_pulmonary_disease,4).
symptom_diagnose(fever,asthma,3).
symptom_diagnose(fever,acute_bronchitis,3).

%sore throat
symptom_diagnose(sore_throat,chronic_obstructive_pulmonary_disease,5).
symptom_diagnose(sore_throat,acute_bronchitis,3).
symptom_diagnose(sore_throat,pneumonia,1).
symptom_diagnose(sore_throat,asthma,0).

%difficulty breathing
symptom_diagnose(difficulty_breathing,asthma,47).
symptom_diagnose(difficulty_breathing,chronic_obstructive_pulmonary_disease,12).
symptom_diagnose(difficulty_breathing,pneumonia,7).
symptom_diagnose(difficulty_breathing,acute_bronchitis,4).

%sharp chest pain
symptom_diagnose(sharp_chest_pain,chronic_obstructive_pulmonary_disease,4).
symptom_diagnose(sharp_chest_pain,pneumonia,3).
symptom_diagnose(sharp_chest_pain,acute_bronchitis,3).
symptom_diagnose(sharp_chest_pain,asthma,2).

%coughing up sputum
symptom_diagnose(coughing_up_sputum,chronic_obstructive_pulmonary_disease,25).
symptom_diagnose(coughing_up_sputum,acute_bronchitis,14).
symptom_diagnose(coughing_up_sputum,asthma,9).
symptom_diagnose(coughing_up_sputum,pneumonia,8).

%coryza
symptom_diagnose(coryza,asthma,7).
symptom_diagnose(coryza,acute_bronchitis,6).
symptom_diagnose(coryza,pneumonia,3).
symptom_diagnose(coryza,chronic_obstructive_pulmonary_disease,2).

%procedure vezane za razlicita pulmoloska oboljenja

%asthma
disease_procedure(asthma,plain_x_ray).
disease_procedure(asthma,nebulizer_therapy).
disease_procedure(asthma,arterial_blood_gases).
disease_procedure(asthma,influenzavirus_antibody_assay).

%pneumonia
disease_procedure(pneumonia,radiographic_imaging_procedure).
disease_procedure(pneumonia,plain_x_ray).
disease_procedure(pneumonia,hematologic_tests).
disease_procedure(pneumonia,complete_blood_count).
disease_procedure(pneumonia,intravenous_fluid_replacement).
disease_procedure(pneumonia,kidney_function_tests).
disease_procedure(pneumonia,electrolytes_panel).

%chronic obstructive pulmonary disease
disease_procedure(chronic_obstructive_pulmonary_disease,radiographic_imaging_procedure).
disease_procedure(chronic_obstructive_pulmonary_disease,plain_x_ray).
disease_procedure(chronic_obstructive_pulmonary_disease,hematologic_tests).
disease_procedure(chronic_obstructive_pulmonary_disease,complete_blood_count).
disease_procedure(chronic_obstructive_pulmonary_disease,glucose_measurement).
disease_procedure(chronic_obstructive_pulmonary_disease,kidney_function_tests).
disease_procedure(chronic_obstructive_pulmonary_disease,electrolytes_panel).

%acute bronchitis
disease_procedure(acute_bronchitis,radiographic_imaging_procedure).
disease_procedure(acute_bronchitis,plain_x_ray).
disease_procedure(acute_bronchitis,nebulizer_therapy).
disease_procedure(acute_bronchitis,kidney_function_tests).
disease_procedure(acute_bronchitis,cardiac_enzymes_measurement).
disease_procedure(acute_bronchitis,cardiac_monitoring).
disease_procedure(acute_bronchitis,blood_culture).

%lista lekova za unetu bolest
medications(B,L) :- findall(A,medication(B,A,V),L).

%lista lekova za unetu bolest sortirana po verovatnoci upotrebe
medications_sorted(B,L) :- findall([V,A],medication(B,A,V),L1),sort(L1,L).

%lista procedura za unetu bolest
procedure_for_disease(B,L) :- findall(P, disease_procedure(B,P),L).

%lista bolesti kod kojih uneti lek pomaze
lek_pomaze_za(M,L) :- findall(B,medication(B,M,V),L).

%lista bolesti za odredjene simptome kao i njihova verovatnoca pojavljivanja
verovatnoca_za_dijagnozu(S,L) :- findall([V,B], symptom_diagnose(S,B,V), L1), sort(L1,L).
