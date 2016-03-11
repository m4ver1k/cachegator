 <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Product Cache Data</h1>
                </div>
</div>
 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        Entry List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                            <button type="button" id="addData" class="btn btn-success" data-toggle="modal" data-target="#addNew">Add Entry</button>
                            <br/>
                            <br/>
                                <!-- <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Cache Key</th>
                                            <th>Value</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX" ng-repeat="cd in cacheData">
                                            <td>{{cd.key}}</td>
                                            <td>{{cd.value}}</td>
                                        </tr>
									</tbody>
                                </table> -->
                                 <div ui-grid="gridOptions" ui-grid-edit class="grid"></div>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

<!--  Modal add new -->
<div class="modal fade" id="addNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Add New</h4>
      </div>
      <div class="modal-body">
      <form>
      			 <div class="form-group">
					<label>Key</label> <input class="form-control" ng-model="ceKey" required="true" >
					<p class="help-block">Key for this Cache entry.</p>
				</div>
				<div class="form-group">
					<label>Value</label> <input class="form-control" ng-model="ceValue" required="true">
					<p class="help-block">Value of this entry.</p>
				</div>
	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" ng-click="addData()">Save</button>
      </div>
    </div>
  </div>
</div>