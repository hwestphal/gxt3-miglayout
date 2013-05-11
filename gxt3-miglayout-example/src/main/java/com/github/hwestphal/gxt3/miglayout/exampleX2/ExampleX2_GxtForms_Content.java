/*
 * Copyright (c) 2013, Harald Westphal
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of the author nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
 * DAMAGE.
 */
package com.github.hwestphal.gxt3.miglayout.exampleX2;

import java.util.List;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.github.hwestphal.gxt3.miglayout.exampleX2.ExampleX2_GxtForms_Content.Contact;
import com.github.hwestphal.gxt3.miglayout.widget.ErrorImage;
import com.github.hwestphal.gxt3.miglayout.widget.ErrorLabel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.AdapterField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.Validator;
import com.sencha.gxt.widget.core.client.form.validator.AbstractValidator;
import com.sencha.gxt.widget.core.client.form.validator.EmptyValidator;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;
import com.sencha.gxt.widget.core.client.form.validator.RegExValidator;

public class ExampleX2_GxtForms_Content implements IsWidget, Editor<Contact> {

	interface Driver extends SimpleBeanEditorDriver<Contact, ExampleX2_GxtForms_Content> {
	}

	Driver driver = GWT.create(Driver.class);

	TextField firstName;
	TextField surname;
	TextField address;
	TextField phone;
	TextField email;

	private MigLayoutContainer container;
	private AdapterField<Contact> form;

	@Override
	public Widget asWidget() {
		if (form == null) {
			container = new MigLayoutContainer();
			final ErrorLabel formError = new ErrorLabel();
			container.add(formError, "hmin 30, span, grow, wrap");
			firstName = addTextField("First Name*", "", "", "", new EmptyValidator<String>());
			surname = addTextField("Surname*", "gap unrelated", "", "wrap", new EmptyValidator<String>());
			address = addTextField("Address*", "", "span 4, grow", "wrap", new EmptyValidator<String>(), new MinLengthValidator(7));
			phone = addTextField("Phone", "", "", "");
			email = addTextField("Email", "gap unrelated", "", "", new RegExValidator(
					"^([\\w\\-\\.]+)@((\\[([0-9]{1,3}\\.){3}[0-9]{1,3}\\])|(([\\w\\-]+\\.)+)([A-Za-z]{2,4}))$", "Must be a valid email address"));

			driver.initialize(this);

			form = new AdapterField<Contact>(container) {
				@Override
				public void setValue(Contact value) {
					driver.edit(value);
				}

				@Override
				public Contact getValue() {
					return driver.flush();
				}
			};
			form.addValidator(new AbstractValidator<Contact>() {
				@Override
				public List<EditorError> validate(Editor<Contact> editor, Contact contact) {
					if (contact != null && (contact.getPhone() == null || contact.getPhone().isEmpty())
							&& (contact.getEmail() == null || contact.getEmail().isEmpty())) {
						return createError(editor, "Either phone or email field must be filled out", contact);
					}
					return null;
				}
			});
			form.setErrorSupport(formError);
			form.setValue(new Contact());
		}
		return form;
	}

	private TextField addTextField(String label, String labelCC, String fieldCC, String errorCC, Validator<?>... validators) {
		final TextField field = new TextField();
		for (Validator<?> validator : validators) {
			@SuppressWarnings("unchecked")
			Validator<String> stringValidator = (Validator<String>) validator;
			field.addValidator(stringValidator);
		}
		ErrorImage error = new ErrorImage();
		field.setErrorSupport(error);
		field.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				field.validate();
				form.validate();
			}
		});

		container.add(new Label(label), labelCC);
		container.add(field, fieldCC);
		container.add(error, errorCC);

		return field;
	}

	static class Contact {
		private String firstName;
		private String surname;
		private String address;
		private String phone;
		private String email;

		String getFirstName() {
			return firstName;
		}

		void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		String getSurname() {
			return surname;
		}

		void setSurname(String surname) {
			this.surname = surname;
		}

		String getAddress() {
			return address;
		}

		void setAddress(String address) {
			this.address = address;
		}

		String getPhone() {
			return phone;
		}

		void setPhone(String phone) {
			this.phone = phone;
		}

		String getEmail() {
			return email;
		}

		void setEmail(String email) {
			this.email = email;
		}
	}

}
