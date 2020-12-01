package org.openmrs.module.ugandaemr.htmlformentry;

import org.openmrs.api.EncounterService;
import org.openmrs.api.context.Context;
import org.openmrs.module.htmlformentry.CustomFormSubmissionAction;
import org.openmrs.module.htmlformentry.FormEntryContext.Mode;
import org.openmrs.module.htmlformentry.FormEntrySession;
import org.openmrs.module.ugandaemr.api.UgandaEMRService;

/**
 * Enrolls patients into DSDM programs
 */
public class LabOrderSubmissionAction implements CustomFormSubmissionAction {

	@Override
	public void applyAction(FormEntrySession session) {
		UgandaEMRService ugandaEMRService = Context.getService(UgandaEMRService.class);
		EncounterService encounterService = Context.getEncounterService();
		Mode mode = session.getContext().getMode();
		if (!(mode.equals(Mode.ENTER) || mode.equals(Mode.EDIT))) {
			return;
		}

		if (mode.equals(Mode.EDIT)) {

		}
		ugandaEMRService.processLabTestOrdersFromEncounterObs(session, true);
	}
}
