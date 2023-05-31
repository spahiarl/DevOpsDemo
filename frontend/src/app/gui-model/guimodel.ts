/* tslint:disable:max-line-length */
export class GuiModel {

    private generateAgeOptions() {
        const options = [];
        for (let i = 10; i <= 65; i++) {
            options.push({ "id": `option${i}`, "value": `${i}` });
        }
        return options;
    }

    private _guiModel = {
        "application": {
            "title": "DevOpsDemo FS2023",
            "formList": [
                {
                    "id": "OwnUserForm",
                    "title": "NotImplemented",
                    "formFieldList": [
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "NotImplementedForm",
                    "title": "Not Implemented",
                    "url": "/dummyform",
                    "headerVisible": false,
                    "footerVisible": false,
                    "borderStyle": "None",
                    "formFieldList": [
                        {
                            "id": "NotImplemented",
                            "type": "label",
                            "name": "NotImplementedMessage",
                            "width": 2
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "NotImplementedFormModal",
                    "title": "NotImplemented",
                    "url": "/dummyform",
                    "formFieldList": [
                        {
                            "id": "NotImplemented",
                            "type": "label",
                            "name": "NotImplementedMessage",
                            "width": 2
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "ToDoForm",
                    "title": { default: "ToDo" },
                    "url": "/todo",
                    "formFieldList": [
                        {
                            "id":   "title",
                            "type": "text",
                            "name": { default: "Titel" },
                            "required": true,
                            "width": 2
                        },
                        {
                            "id": "description",
                            "type": "text",
                            "name": { default: "Text" },
                            "newRow": true,
                            "maxLength": 4000,
                            "height": 4,
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "NewPersonForm",
                    "title": "Neue Person",
                    "formFieldList": [
                        {
                            "id": "firstName",
                            "type": "text",
                            "name": "Vorname",
                            "required": true,
                            "width": 2
                        },
                        {
                            "id": "lastName",
                            "type": "text",
                            "name": "Nachname",
                            "required": true,
                            "width": 2
                        },
                        {
                            "id": "age",
                            "type": "select",
                            "name": "Alter",
                            "options": this.generateAgeOptions(),
                            "width": 2
                        },
                        {
                            "type": "createButton",
                            "name": "Erstellen"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Abbrechen"
                        }
                    ]
                }
            ],
            "pageList": [
                {
                    "id": "mainmenu",
                    "name": "MainMenu",
                    "elementList": [
                        {
                            "type": "pageLabel",
                            "value": "<h4>Willkommen bei DevOps</h4>",
                            "newRow": true
                        },
                        {
                            "type": "button",
                            "name": { default: "ToDo-List" },
                            "icon": "fa-file-alt",
                            "color": "wet-asphalt",
                            "page": "toDoPage",
                            "width": 2,
                            "newRow": true,
                        },
                    ]
                },
                {
                    "id": "toDoPage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": { default: "Neues ToDo"},
                            "icon": "fa-user",
                            "color": "green",
                            "width": 2,
                            "form" : {
                                "form" : "ToDoForm"
                            }
                        },
                        {
                            "type": "list",
                            "name": "ToDo",
                            "icon": "fa-user",
                            "color": "wet-asphalt",
                            "search": true,
                            "url": "/todo",
                            "form": {
                                "form": "ToDoForm"
                            }
                        }
                    ]
                },
                {
                    "id": "personPage",
                    "elementList": [
                        {
                            "type": "backButton"
                        },
                        {
                            "type": "newButton",
                            "name": "Neue Person",
                            "icon": "fa-user",
                            "color": "green",
                            "width": 2,
                            "form": {
                                "form": "NewPersonForm"
                            }
                        },
                        {
                            "type": "list",
                            "name": "Personen",
                            "icon": "fa-user",
                            "color": "wet-asphalt",
                            "search": true,
                            "url": "/person",
                            "form": {
                                "form": "NewPersonForm"
                            }
                        }
                    ]
                }
            ]
        }
    };


    get guiModel() {
        return this._guiModel;
    }
}